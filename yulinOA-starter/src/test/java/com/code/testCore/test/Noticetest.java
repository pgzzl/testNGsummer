package com.code.testCore.test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horsecoder.common.status.StatusException;
import com.AppStarter;
import com.horsecoder.yulinOA.sys.datafilter.*;
import com.horsecoder.yulinOA.sys.datainterface.*;
import com.horsecoder.yulinOA.sys.dataobject.*;
import com.horsecoder.yulinOA.sys.model.*;
import com.horsecoder.yulinOA.sys.service.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@SpringBootTest(classes = AppStarter.class)
public class Noticetest {
	@Mock
	public NoticeDAO noticedao;

	@Mock
	public NoticeSimpleMapper noticeSimpleMapper;

	@Mock
	public Notice notice;

	@Mock
	public NoticeFilterMapper noticefilterMapper;

	@InjectMocks
	public NoticeService noticeService;

	public List<Map<String, Object>> carList;

	public Map<String, Object> mockParams;


	@BeforeTest(alwaysRun = true)
	public void beforeTest()
	{
		MockitoAnnotations.initMocks(this);
        String test =this.getClass().getName();
        String id=prepareData(test);
	}

	
	public String prepareData(String key)
	{
		System.out.println(key);
        return key;
	}

	
	public static List<Map<String, Object>> loadData(String key)
	{
		        Jedis jedis = new Jedis("127.0.0.1", 6379);
        ObjectMapper objectMapper = new ObjectMapper();
        long len = jedis.llen(key);
        List<Map<String, Object>> Objs = new ArrayList<>();
        try {
            while (len-- > 0) {
                Map map = objectMapper.readValue(jedis.lpop(key), Map.class);
                Objs.add(map);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            return Objs;
        }
	}

	@Test(groups = "groupGet")
	public void getByPKTest()
	{
		String testid = "1";
        NoticeDO noticedo = new NoticeDO();
        noticedo.setId(testid);
        Mockito.when(noticedao.selectByPrimaryKey(testid)).thenReturn(noticedo);
        Assert.assertEquals(noticeService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = noticeSimpleMapper.buildMap(noticeService.getByPK(testid));
       Assert.assertEquals(noticeService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(noticeService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, noticeService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(noticefilterMapper).buildMap();
        NoticeDOExample example = NoticeFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(noticedao).countByExample(example);
        Assert.assertEquals(count, noticeService.getCountByFilter(noticefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Notice> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(noticefilterMapper).buildMap();
        NoticeDOExample example = NoticeFilter.initDOQueryFilter(mockParams);

        List<Notice> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(noticedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, noticeService.getListByFilter(noticefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Notice> t1 = Mockito.mock(ArrayList.class);
        List<Notice> t2 = null;
        Mockito.when(noticeService.getListByFilter(noticefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Notice.class.getDeclaredMethod("accept", Notice.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(NoticeSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, noticeService.getFilterMapList(noticefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        notice = new Notice();
        Mockito.when(noticedao.insertSelective(NoticeData.convert(notice, new NoticeDO()))).thenThrow(e);
        Notice res = noticeService.post(notice);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Notice test = new  Notice();
 Notice spyNotice = Mockito.spy(test);
        Mockito.when(noticedao.insertSelective(NoticeData.convert(test, new NoticeDO()))).thenReturn(1);
        Notice res = noticeService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(noticedao.updateByPrimaryKeySelective(NoticeData.convert(notice, new NoticeDO()))).thenReturn(1);
        Assert.assertEquals(actual, noticedao.updateByPrimaryKeySelective(NoticeData.convert(notice, new NoticeDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Notice putEntity=new Notice();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(noticeService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(noticedao.insertSelective(NoticeData.convert(putEntity, new NoticeDO()))).thenReturn(1);
        Assert.assertEquals(actual,noticeService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(noticedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = noticeService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = noticeService.getFilterListGroup(noticefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}