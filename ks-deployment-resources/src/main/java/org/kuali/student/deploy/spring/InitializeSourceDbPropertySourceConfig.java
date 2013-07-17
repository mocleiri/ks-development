package org.kuali.student.deploy.spring;

import java.util.List;

import org.kuali.common.util.config.spring.BuildPropertySourceConfig;
import org.kuali.student.deploy.config.SourceDbConfigConstants;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeSourceDbPropertySourceConfig extends BuildPropertySourceConfig {

	@Override
	protected List<String> getConfigIds() {
		return SourceDbConfigConstants.INIT_SOURCE_DB_CONFIG_IDS;
	}

}
