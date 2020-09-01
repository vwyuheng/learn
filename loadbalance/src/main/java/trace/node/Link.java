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
public class Link {
	private String id;  //节点id
	private String  source;
	private String target;

	@Tolerate
	public Link() {}
}
