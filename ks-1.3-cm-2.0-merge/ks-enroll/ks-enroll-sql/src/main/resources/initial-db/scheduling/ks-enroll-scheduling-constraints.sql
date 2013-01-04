CREATE  INDEX KSEN_SCHED_RQST_I1 ON KSEN_SCHED_RQST
(REF_OBJECT_ID   ASC,REF_OBJECT_TYPE   ASC)
/


CREATE  INDEX KSEN_SCHED_RQST_ATTR_IF1 ON KSEN_SCHED_RQST_ATTR
(OWNER_ID   ASC)
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_IF1 ON KSEN_SCHED_RQST_CMP
(SCHED_RQST_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_CMP_BLDG_I1 ON KSEN_SCHED_RQST_CMP_BLDG
(CMP_ID   ASC,BUILDING_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_BLDG
ADD CONSTRAINT  KSEN_SCHED_RQST_CMP_BLDG_I1 UNIQUE (CMP_ID,BUILDING_ID)   USING INDEX KSEN_SCHED_RQST_CMP_BLDG_I1
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_BLDG_IF1 ON KSEN_SCHED_RQST_CMP_BLDG
(CMP_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_CMP_CAMPUS_I1 ON KSEN_SCHED_RQST_CMP_CAMPUS
(CMP_ID   ASC,CAMPUS_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_CAMPUS
ADD CONSTRAINT  KSEN_SCHED_RQST_CMP_CAMPUS_I1 UNIQUE (CMP_ID,CAMPUS_ID)   USING INDEX KSEN_SCHED_RQST_CMP_CAMPUS_I1
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_CAMPUS_IF1 ON KSEN_SCHED_RQST_CMP_CAMPUS
(CMP_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_CMP_ORG_I1 ON KSEN_SCHED_RQST_CMP_ORG
(CMP_ID   ASC,ORG_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ORG
ADD CONSTRAINT  KSEN_SCHED_RQST_CMP_ORG_I1 UNIQUE (CMP_ID,ORG_ID)   USING INDEX KSEN_SCHED_RQST_CMP_ORG_I1
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_ORG_IF1 ON KSEN_SCHED_RQST_CMP_ORG
(CMP_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_CMP_ROOM_I1 ON KSEN_SCHED_RQST_CMP_ROOM
(CMP_ID   ASC,ROOM_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ROOM
ADD CONSTRAINT  KSEN_SCHED_RQST_CMP_ROOM_I1 UNIQUE (CMP_ID,ROOM_ID)   USING INDEX KSEN_SCHED_RQST_CMP_ROOM_I1
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_ROOM_IF1 ON KSEN_SCHED_RQST_CMP_ROOM
(CMP_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_RT_I1 ON KSEN_SCHED_RQST_CMP_RT
(CMP_ID   ASC,RSRC_TYPE_KEY   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_RT
ADD CONSTRAINT  KSEN_SCHED_RQST_RT_I1 UNIQUE (CMP_ID,RSRC_TYPE_KEY)   USING INDEX KSEN_SCHED_RQST_RT_I1
/


CREATE  INDEX KSEN_SCHED_RQST_RT_IF1 ON KSEN_SCHED_RQST_CMP_RT
(CMP_ID   ASC)
/


CREATE UNIQUE INDEX KSEN_SCHED_RQST_CMP_TMSLOT_I1 ON KSEN_SCHED_RQST_CMP_TMSLOT
(CMP_ID   ASC,TM_SLOT_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_CMP_TMSLOT
ADD CONSTRAINT  KSEN_SCHED_RQST_CMP_TMSLOT_I1 UNIQUE (CMP_ID,TM_SLOT_ID)   USING INDEX KSEN_SCHED_RQST_CMP_TMSLOT_I1
/


CREATE  INDEX KSEN_SCHED_RQST_CMP_TMSLOT_IF1 ON KSEN_SCHED_RQST_CMP_TMSLOT
(CMP_ID   ASC)
/


ALTER TABLE KSEN_SCHED_RQST_ATTR
	ADD (CONSTRAINT KSEN_SCHED_REQUEST_ATTR_FK1 FOREIGN KEY (OWNER_ID) REFERENCES KSEN_SCHED_RQST (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_FK1 FOREIGN KEY (SCHED_RQST_ID) REFERENCES KSEN_SCHED_RQST (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_BLDG
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_BLDG_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_CAMPUS
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_CAMPUS_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ORG
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_ORG_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_ROOM
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_ROOM_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_RT
	ADD (CONSTRAINT KSEN_SCHED_RQST_RT_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


ALTER TABLE KSEN_SCHED_RQST_CMP_TMSLOT
	ADD (CONSTRAINT KSEN_SCHED_RQST_CMP_TMSLOT_FK1 FOREIGN KEY (CMP_ID) REFERENCES KSEN_SCHED_RQST_CMP (ID))
/


