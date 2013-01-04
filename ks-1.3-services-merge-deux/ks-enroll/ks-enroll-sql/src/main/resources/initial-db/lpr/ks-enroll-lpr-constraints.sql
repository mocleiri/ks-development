CREATE  INDEX KSEN_LPR_I1 ON KSEN_LPR
(PERS_ID   ASC,LPR_TYPE   ASC,LPR_STATE   ASC)
/


CREATE  INDEX KSEN_LPR_I2 ON KSEN_LPR
(LUI_ID   ASC,LPR_TYPE   ASC,LPR_STATE   ASC)
/


CREATE  INDEX KSEN_LPR_I3 ON KSEN_LPR
(PERS_ID   ASC,LUI_ID   ASC)
/


CREATE  INDEX KSEN_LPR_I4 ON KSEN_LPR
(PERS_ID   ASC,LPR_TYPE   ASC)
/


CREATE  INDEX KSEN_LPR_ATTR_IF1 ON KSEN_LPR_ATTR
(OWNER_ID   ASC)
/


ALTER TABLE KSEN_LPR_RESULT_VAL_GRP
ADD CONSTRAINT  KSEN_LPR_RESULT_VAL_GRP_I1 UNIQUE (LPR_ID,RESULT_VAL_GRP_ID)
/


CREATE  INDEX KSEN_LPR_RESULT_VAL_GRP_IF1 ON KSEN_LPR_RESULT_VAL_GRP
(LPR_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_I1 ON KSEN_LPR_ROSTER
(LPR_ROSTER_TYPE   ASC)
/


ALTER TABLE KSEN_LPR_ROSTER_ASSO_LUI_ID
ADD CONSTRAINT  KSEN_LPR_ROSTER_ASSO_LUI_ID_I1 UNIQUE (LPR_ROSTER_ID,LUI_ID)
/


CREATE  INDEX KSEN_LPR_ROSTER_ASSO_LUI_ID_I2 ON KSEN_LPR_ROSTER_ASSO_LUI_ID
(LUI_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_ASSO_LUI_ID_IF ON KSEN_LPR_ROSTER_ASSO_LUI_ID
(LPR_ROSTER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_ATTR_IF1 ON KSEN_LPR_ROSTER_ATTR
(OWNER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_ENTRY_IF1 ON KSEN_LPR_ROSTER_ENTRY
(LPR_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_ENTRY_IF2 ON KSEN_LPR_ROSTER_ENTRY
(LPR_ROSTER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_ROSTER_ENTRY_ATTR_IF1 ON KSEN_LPR_ROSTER_ENTRY_ATTR
(OWNER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_I1 ON KSEN_LPR_TRANS
(LPR_TRANS_STATE   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_I2 ON KSEN_LPR_TRANS
(REQUESTING_PERS_ID   ASC,ATP_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ATTR_IF1 ON KSEN_LPR_TRANS_ATTR
(OWNER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_I1 ON KSEN_LPR_TRANS_ITEM
(PERS_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_I2 ON KSEN_LPR_TRANS_ITEM
(NEW_LUI_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_I3 ON KSEN_LPR_TRANS_ITEM
(EXISTING_LUI_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_I4 ON KSEN_LPR_TRANS_ITEM
(LTI_RESULTING_LPR_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_IF1 ON KSEN_LPR_TRANS_ITEM
(LPR_TRANS_ID   ASC)
/


CREATE  INDEX KSEN_LPR_TRANS_ITEM_ATTR_IF1 ON KSEN_LPR_TRANS_ITEM_ATTR
(OWNER_ID   ASC)
/


CREATE  INDEX KSEN_LPR_LTI_RQST_OPT_IF1 ON KSEN_LPR_TRANS_ITEM_RQST_OPT
(LPR_TRANS_ITEM_ID   ASC)
/


ALTER TABLE KSEN_LPR_TRANS_ITEM_RVG
ADD CONSTRAINT  KSEN_LPR_LTI_RVG_I1 UNIQUE (LPR_TRANS_ITEM_ID,RESULT_VAL_GRP_ID)
/


CREATE  INDEX KSEN_LPR_LTI_RVG_IF1 ON KSEN_LPR_TRANS_ITEM_RVG
(LPR_TRANS_ITEM_ID   ASC)
/


ALTER TABLE KSEN_LPR_ATTR
	ADD (CONSTRAINT KSEN_LPR_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_LPR (ID))
/


ALTER TABLE KSEN_LPR_RESULT_VAL_GRP
	ADD (CONSTRAINT KSEN_LPR_RESULT_VAL_GRP_KF1 FOREIGN KEY (LPR_ID) REFERENCES KSEN_LPR (ID))
/


ALTER TABLE KSEN_LPR_ROSTER_ASSO_LUI_ID
	ADD (CONSTRAINT KSEN_LPR_ROSTER_ASSO_LUI_ID_FK FOREIGN KEY (LPR_ROSTER_ID) REFERENCES KSEN_LPR_ROSTER (ID))
/


ALTER TABLE KSEN_LPR_ROSTER_ATTR
	ADD (CONSTRAINT KSEN_LPR_ROSTER_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_LPR_ROSTER (ID))
/


ALTER TABLE KSEN_LPR_ROSTER_ENTRY
	ADD (CONSTRAINT KSEN_LPR_ROSTER_ENTRY_FK1 FOREIGN KEY (LPR_ID) REFERENCES KSEN_LPR (ID))
/


ALTER TABLE KSEN_LPR_ROSTER_ENTRY
	ADD (CONSTRAINT KSEN_LPR_ROSTER_ENTRY_FK2 FOREIGN KEY (LPR_ROSTER_ID) REFERENCES KSEN_LPR_ROSTER (ID))
/


ALTER TABLE KSEN_LPR_ROSTER_ENTRY_ATTR
	ADD (CONSTRAINT KSEN_LPR_ROSTER_ENTRY_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_LPR_ROSTER_ENTRY (ID))
/


ALTER TABLE KSEN_LPR_TRANS_ATTR
	ADD (CONSTRAINT KSEN_LPR_TRANS_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_LPR_TRANS (ID))
/


ALTER TABLE KSEN_LPR_TRANS_ITEM
	ADD (CONSTRAINT KSEN_LPR_TRANS_ITEM_FK1 FOREIGN KEY (LPR_TRANS_ID) REFERENCES KSEN_LPR_TRANS (ID))
/


ALTER TABLE KSEN_LPR_TRANS_ITEM_ATTR
	ADD (CONSTRAINT KSEN_LPR_TRANS_ITEM_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_LPR_TRANS_ITEM (ID))
/


ALTER TABLE KSEN_LPR_TRANS_ITEM_RQST_OPT
	ADD (CONSTRAINT KSEN_LPR_LTI_RQST_OPT_FK1 FOREIGN KEY (LPR_TRANS_ITEM_ID) REFERENCES KSEN_LPR_TRANS_ITEM (ID))
/


ALTER TABLE KSEN_LPR_TRANS_ITEM_RVG
	ADD (CONSTRAINT KSEN_LPR_LTI_RVG_FK1 FOREIGN KEY (LPR_TRANS_ITEM_ID) REFERENCES KSEN_LPR_TRANS_ITEM (ID))
/


