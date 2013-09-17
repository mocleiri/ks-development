package org.kuali.student.r2.core.constants;

import org.kuali.student.r2.common.constants.CommonServiceConstants;
import org.kuali.student.r2.core.comment.dto.CommentInfo;

/**
 * This class holds the constants used by the Comment service
 *
 * @Version 2.0
 * @Author Sri komandur@uw.edu
 *
 */
public class CommentServiceConstants {
    /**
     * Reference Object URI's
     */
    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "comment";
    public static final String REF_OBJECT_URI_COMMENT = NAMESPACE + "/" + CommentInfo.class.getSimpleName();

    //comment types
    public static final String GENERAL_REMARKS_COMMENT_TYPE = "kuali.comment.type.generalRemarks";

    public static final String ACKNOWLEDGE_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.acknowledge";
    public static final String APPROVE_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.approve";
    public static final String BLANKET_APPROVE_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.blanketApprove";
    public static final String CANCEL_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.cancelWorkflow";
    public static final String FYI_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.fyi";
    public static final String REJECT_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.reject";
    public static final String RETURN_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.return";
    public static final String WITHDRAW_WORKFLOW_DECISION_COMMENT_TYPE = "kuali.comment.type.workflowDecisionRationale.withdraw";

}
