package org.kuali.student.deploy;

import org.kuali.common.util.KualiProjectConstants;
import org.kuali.common.util.project.ImmutableProject;

public abstract class DeployProjectConstants {

	public static final ImmutableProject PROJECT = new ImmutableProject(KualiProjectConstants.STUDENT_GROUP_ID, "ks-deployment-resources");

	@Deprecated
	public static final String KS_SOURCE_DB_ARTIFACT_ID = "ks-source-db";

	@Deprecated
	public static final String GROUP_ID = KualiProjectConstants.STUDENT_GROUP_ID;

	@Deprecated
	public static final String ARTIFACT_ID = "ks-deployment-resources";

	@Deprecated
	public static final String GROUP_ID_BASE = GROUP_ID;

	@Deprecated
	public static final String KS_SOURCE_DB_RESOURCE_PREFIX = null; // ProjectUtils.getClassPathPrefix(GROUP_ID, KS_SOURCE_DB_ARTIFACT_ID);

	@Deprecated
	public static final String KS_SOURCE_DB_COMMON = KS_SOURCE_DB_RESOURCE_PREFIX + "/common.properties";

}
