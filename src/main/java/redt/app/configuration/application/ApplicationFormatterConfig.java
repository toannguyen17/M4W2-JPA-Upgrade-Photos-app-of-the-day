package redt.app.configuration.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationFormatterConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addFormatters(FormatterRegistry registry)	{
		// registry.addFormatter(//...///);
	}
}
