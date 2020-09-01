package trace;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * Created by yushuqiang on 2019/3/28 上午10:46
 */
@Data
@Builder
@ToString
public class TraceLogData {

	private  String traceId;
	private String deepId;
	private String appName;
	private String serviceName;  //接口全路径名称(package+class+methodName)

	@Tolerate
	public TraceLogData() {}
	//....
}
