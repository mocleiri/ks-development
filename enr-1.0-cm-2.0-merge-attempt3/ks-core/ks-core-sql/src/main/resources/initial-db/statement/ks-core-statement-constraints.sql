
ALTER TABLE KSST_OBJECT_SUB_TYPE_ATTR
    ADD CONSTRAINT KSST_OBJECT_SUB_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_OBJECT_SUB_TYPE (TYPE_KEY)
/



ALTER TABLE KSST_OBJECT_TYPE_ATTR
    ADD CONSTRAINT KSST_OBJECT_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_OBJECT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_OBJ_TYP_JN_OBJ_SUB_TYP
    ADD CONSTRAINT KSST_OBJ_TYP_JN_OBJ_SUBTYP_FK1 FOREIGN KEY (OBJ_SUB_TYPE_ID)
    REFERENCES KSST_OBJECT_SUB_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_OBJ_TYP_JN_OBJ_SUB_TYP
    ADD CONSTRAINT KSST_OBJ_TYP_JN_OBJ_SUBTYP_FK2 FOREIGN KEY (OBJ_TYPE_ID)
    REFERENCES KSST_OBJECT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_RCTYP_JN_RCFLDTYP
    ADD CONSTRAINT KSST_RCTYP_JN_RCFLDTYP_FK1 FOREIGN KEY (REQ_COMP_FIELD_TYPE_ID)
    REFERENCES KSST_REQ_COM_FIELD_TYPE (ID)
/

ALTER TABLE KSST_RCTYP_JN_RCFLDTYP
    ADD CONSTRAINT KSST_RCTYP_JN_RCFLDTYP_FK2 FOREIGN KEY (REQ_COMP_TYPE_ID)
    REFERENCES KSST_REQ_COM_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_RC_JN_RC_FIELD
    ADD CONSTRAINT KSST_RC_JN_RC_FIELD_FK1 FOREIGN KEY (REQ_COM_ID)
    REFERENCES KSST_REQ_COM (ID)
/

ALTER TABLE KSST_RC_JN_RC_FIELD
    ADD CONSTRAINT KSST_RC_JN_RC_FIELD_FK2 FOREIGN KEY (REQ_COM_FIELD_ID)
    REFERENCES KSST_REQ_COM_FIELD (ID)
/


ALTER TABLE KSST_REF_STMT_REL
    ADD CONSTRAINT KSST_REF_STMT_REL_FK1 FOREIGN KEY (REF_STMT_REL_TYPE_ID)
    REFERENCES KSST_REF_STMT_REL_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_REF_STMT_REL
    ADD CONSTRAINT KSST_REF_STMT_REL_FK2 FOREIGN KEY (STMT_ID)
    REFERENCES KSST_STMT (ID)
/


ALTER TABLE KSST_REF_STMT_REL_ATTR
    ADD CONSTRAINT KSST_REF_STMT_REL_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_REF_STMT_REL (ID)
/



ALTER TABLE KSST_REF_STMT_REL_TYPE_ATTR
    ADD CONSTRAINT KSST_REF_STMT_REL_TYP_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_REF_STMT_REL_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_REQ_COM
    ADD CONSTRAINT KSST_REQ_COM_FK1 FOREIGN KEY (REQ_COM_TYPE_ID)
    REFERENCES KSST_REQ_COM_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_REQ_COM
    ADD CONSTRAINT KSST_REQ_COM_FK2 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSST_RICH_TEXT_T (ID)
/





ALTER TABLE KSST_REQ_COM_TYPE_ATTR
    ADD CONSTRAINT KSST_REQ_COM_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_REQ_COM_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_REQ_COM_TYPE_NL_TMPL
    ADD CONSTRAINT KSST_REQ_COM_TYPE_NL_TMPL_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_REQ_COM_TYPE (TYPE_KEY)
/



ALTER TABLE KSST_RSTMT_RTYP_JN_OSUB_TYP
    ADD CONSTRAINT KSST_RSTMT_RTYP_JN_OSUBTYP_FK1 FOREIGN KEY (OBJ_SUB_TYPE_ID)
    REFERENCES KSST_OBJECT_SUB_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_RSTMT_RTYP_JN_OSUB_TYP
    ADD CONSTRAINT KSST_RSTMT_RTYP_JN_OSUBTYP_FK2 FOREIGN KEY (REF_STMT_REL_TYPE_ID)
    REFERENCES KSST_REF_STMT_REL_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_RSTMT_RTYP_JN_STMT_TYP
    ADD CONSTRAINT KSST_RSTMT_RTYP_JN_ST_TYP_FK1 FOREIGN KEY (REF_STMT_REL_TYPE_ID)
    REFERENCES KSST_REF_STMT_REL_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_RSTMT_RTYP_JN_STMT_TYP
    ADD CONSTRAINT KSST_RSTMT_RTYP_JN_ST_TYP_FK2 FOREIGN KEY (STMT_TYPE_ID)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_STMT
    ADD CONSTRAINT KSST_STMT_FK1 FOREIGN KEY (STMT_TYPE_ID)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_STMT
    ADD CONSTRAINT KSST_STMT_FK2 FOREIGN KEY (RT_DESCR_ID)
    REFERENCES KSST_RICH_TEXT_T (ID)
/


ALTER TABLE KSST_STMT_ATTR
    ADD CONSTRAINT KSST_STMT_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_STMT (ID)
/


ALTER TABLE KSST_STMT_JN_REQ_COM
    ADD CONSTRAINT KSST_STMT_JN_REQ_COM_FK1 FOREIGN KEY (STMT_ID)
    REFERENCES KSST_STMT (ID)
/

ALTER TABLE KSST_STMT_JN_REQ_COM
    ADD CONSTRAINT KSST_STMT_JN_REQ_COM_FK2 FOREIGN KEY (REQ_COM_ID)
    REFERENCES KSST_REQ_COM (ID)
/


ALTER TABLE KSST_STMT_JN_STMT
    ADD CONSTRAINT KSST_STMT_JN_STMT_FK1 FOREIGN KEY (STMT_ID)
    REFERENCES KSST_STMT (ID)
/

ALTER TABLE KSST_STMT_JN_STMT
    ADD CONSTRAINT KSST_STMT_JN_STMT_FK2 FOREIGN KEY (CHLD_STMT_ID)
    REFERENCES KSST_STMT (ID)
/



ALTER TABLE KSST_STMT_TYPE_ATTR
    ADD CONSTRAINT KSST_STMT_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_STMT_TYP_JN_RC_TYP
    ADD CONSTRAINT KSST_STMT_TYP_JN_RC_TYP_FK1 FOREIGN KEY (REQ_COM_TYPE_ID)
    REFERENCES KSST_REQ_COM_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_STMT_TYP_JN_RC_TYP
    ADD CONSTRAINT KSST_STMT_TYP_JN_RC_TYP_FK2 FOREIGN KEY (STMT_TYPE_ID)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_STMT_TYP_JN_STMT_TYP
    ADD CONSTRAINT KSST_STMT_TYP_JN_STMT_TYP_FK1 FOREIGN KEY (CHLD_STMT_TYPE_ID)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/

ALTER TABLE KSST_STMT_TYP_JN_STMT_TYP
    ADD CONSTRAINT KSST_STMT_TYP_JN_STMT_TYP_FK2 FOREIGN KEY (STMT_TYPE_ID)
    REFERENCES KSST_STMT_TYPE (TYPE_KEY)
/


ALTER TABLE KSST_USAGE_TYPE_ATTR
    ADD CONSTRAINT KSST_USAGE_TYPE_ATTR_FK1 FOREIGN KEY (OWNER)
    REFERENCES KSST_NL_USAGE_TYPE (TYPE_KEY)
/

