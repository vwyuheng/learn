package trace.node;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yushuqiang on 2019/3/28 下午12:08
 */
@Data
public class Tracer {

	private List<Link> links;
	private List<Node> nodes;


	public Tracer() {
		links = new LinkedList<>();
		nodes = new LinkedList<>();
	}
}
