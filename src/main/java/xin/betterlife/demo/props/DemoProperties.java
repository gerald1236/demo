package xin.betterlife.demo.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DemoProperties
 *
 * @author Steven Chen
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
	/**
	 * 名称
	 */
	private String name;
}
