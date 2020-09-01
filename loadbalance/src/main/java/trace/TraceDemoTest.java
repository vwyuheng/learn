package trace;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import trace.node.Link;
import trace.node.Node;
import trace.node.Tracer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yushuqiang on 2019/3/28 上午10:45
 */
public class TraceDemoTest {


	@Test
	public void testTraceDemo() {
		//模拟的是 五个node 四个link
		/**
		 * Tracer(links=[
		 *     Link(id=0,
		 *     source=0,
		 *     target=0.1),
		 *     Link(id=0,
		 *     source=0,
		 *     target=0.2),
		 *     Link(id=0.1,
		 *     source=0.1,
		 *     target=0.1.1),
		 *     Link(id=0.2,
		 *     source=0.2,
		 *     target=0.2.1)
		 * ],
		 * nodes=[
		 *     Node(id=0,
		 *     appName=app1,
		 *     nodeName=com.test.demo.DemoService1.methodTest1,
		 *     deepId=0,
		 *     parentDeepId=0),
		 *     Node(id=0.1,
		 *     appName=app2,
		 *     nodeName=com.test.demo.DemoService2.methodTest2,
		 *     deepId=0.1,
		 *     parentDeepId=0),
		 *     Node(id=0.2,
		 *     appName=app2,
		 *     nodeName=com.test.demo.DemoService2.methodTest4,
		 *     deepId=0.2,
		 *     parentDeepId=0),
		 *     Node(id=0.1.1,
		 *     appName=app3,
		 *     nodeName=com.test.demo.DemoService3.methodTest3,
		 *     deepId=0.1.1,
		 *     parentDeepId=0.1),
		 *     Node(id=0.2.1,
		 *     appName=app4,
		 *     nodeName=com.test.demo.DemoService4.methodTest4,
		 *     deepId=0.2.1,
		 *     parentDeepId=0.2)
		 * ])"
		 *
		 * ***/
		//1.根据tracied 001查询该调用链数据列表
		List<TraceLogData> traceLogDataList = this.buildSpanList("001");

		System.out.println(JSON.toJSONString("11111111traceLogDataListJSON=" + this.buildTracer(traceLogDataList)));

	}

	protected Tracer buildTracer(List<TraceLogData> traceLogDataList) {
		if (traceLogDataList == null || traceLogDataList.size() == 0) {
			return null;
		}
		//2.节点
		Map<String, Node> nodes = new HashMap<>();
		//3.节点关系
		List<Link> links = new LinkedList<>();

		//Node childNode = null;
		traceLogDataList.forEach(

				traceLogData -> {
					Node childNode = null;
					if (!nodes.containsKey(traceLogData.getDeepId())) {
						childNode = buildNode(traceLogData);
						nodes.put(traceLogData.getDeepId(), childNode);
					}

				}
		);

		if (nodes != null && nodes.size() != 0) {
			for (Map.Entry<String, Node> entry : nodes.entrySet()) {
				Link link = new Link();
				String deepId = entry.getKey();
				Node node = entry.getValue();
				link.setId(node.getParentDeepId());
				link.setSource(node.getParentDeepId());
				link.setTarget(deepId);

				if (!link.getSource().equalsIgnoreCase(link.getTarget())) {
					links.add(link);
				}

			}
		}
		//5. 返回节点信息和节点关系信息

		Tracer tracer = new Tracer();
		tracer.getLinks().addAll(links);
		tracer.getNodes().addAll(nodes.values());
		return tracer;
	}

	//构建节点
	protected Node buildNode(TraceLogData traceLogData) {

		return Node.builder()
				.id(traceLogData.getDeepId())
				.nodeName(traceLogData.getServiceName())
				.appName(traceLogData.getAppName())
				.deepId(traceLogData.getDeepId())
				.parentDeepId(traceLogData.getDeepId().equalsIgnoreCase("0") ?
						"0" :
						traceLogData.getDeepId().substring(0, traceLogData.getDeepId().lastIndexOf(".")))
				.build();
	}

	//构建span列表
	protected List<TraceLogData> buildSpanList(String traceId) {

		TraceLogData traceLogData1 = TraceLogData.builder()
				.appName("app1")
				.deepId("0")
				.traceId("001")
				.serviceName("com.test.demo.DemoService1.methodTest1").build();

		TraceLogData traceLogData2 = TraceLogData.builder()
				.appName("app2")
				.deepId("0.1")
				.traceId("001")
				.serviceName("com.test.demo.DemoService2.methodTest2").build();

		TraceLogData traceLogData3 = TraceLogData.builder()
				.appName("app3")
				.deepId("0.1.1")
				.traceId("001")
				.serviceName("com.test.demo.DemoService3.methodTest3").build();

		TraceLogData traceLogData4 = TraceLogData.builder()
				.appName("app2")
				.deepId("0.2")
				.traceId("001")
				.serviceName("com.test.demo.DemoService2.methodTest4").build();

		TraceLogData traceLogData5 = TraceLogData.builder()
				.appName("app4")
				.deepId("0.2.1")
				.traceId("001")
				.serviceName("com.test.demo.DemoService4.methodTest4").build();

		List<TraceLogData> traceLogDataList = new ArrayList<>(Arrays.asList(
				traceLogData1,
				traceLogData2,
				traceLogData3,
				traceLogData4,
				traceLogData5));

		return traceLogDataList;
	}
}
