package trace.node;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * Created by yushuqiang on 2019/3/28 上午11:01
 */
@Data
@Builder
@ToString
public class Node {
	private String id;
	private String appName;
	private String nodeName;
	private String deepId;
	private String parentDeepId;

	@Tolerate
	public Node(){}
}
