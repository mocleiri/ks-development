--script to setup STUDENT affiliated users for Black PDT KSAP development...per KSAP-243, KSAP-536 and KSENROLL-12168
--create update stmts to convert faculty/staff to student [default] affiliations
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-6150' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-2087' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8842' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8625' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-5820' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10036' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11840' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-9117' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10040' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3195' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11784' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-7347' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-2345' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8887' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10926' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-6168' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8935' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8063' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-7956' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-6812' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-9450' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8758' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-6468' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-1941' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3899' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11901' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3873' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3267' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-7185' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-4419' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10613' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-9488' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-1662' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-4220' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-4801' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11612' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-2886' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-2998' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-2032' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11909' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-7271' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8028' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-5053' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8805' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-1755' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-9890' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-8212' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10339' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-1968' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3829' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-9864' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11143' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-1747' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3394' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10136' and afltn_typ_cd='FCLTY'
/
--create Insert stmts to add student [non-default] affiliation ...along with faculty affilation
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '436095A24AC544CA8C3F23D8E0BA78F1','KS-7817',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', 'B7311634F89B4F64AD867852F5EF33D2','KS-7838',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '0C5F98EECE8346579887FC7EFDCEEF98','KS-4485',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '8BEC57BE2FB6437189E9D3201C8E4D38','KS-8590',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', 'C424CB99F1AD47228D1CEBC9FF6F80FF','KS-4556',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', 'EE34BFBF5AF747FD84FB16AE628CDEE8','KS-4381',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '6E45325064BB46D7BCC7B557FD787ED9','KS-7344',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '6A8470808A3C4ED0B566CDBE57C70809','KS-5819',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', '79B1D07CDED94563ACC76BF6CBCBF624','KS-9877',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STDNT', '0', 'N', 'DF5B523953B74E31B4BCA445E804BD12','KS-10370',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
--create Insert stmts to add student [default] affiliation ...and insert staff [non-default] affilation
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-12187' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-6624' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10506' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-5040' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3928' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3677' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-3658' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-7642' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-10232' and afltn_typ_cd='FCLTY'
/
UPDATE KRIM_ENTITY_AFLTN_T
set AFLTN_TYP_CD='STDNT', DFLT_IND='Y', LAST_UPDT_DT=TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' )
where entity_id='KS-11857' and afltn_typ_cd='FCLTY'
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '9C8D7D7F409B4B3880A0EAB15B0037B3','KS-7642',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', 'FC4486C4258C4739AD6A670E2A9D980F','KS-5040',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '16F1D35ECD00424489CA4ABDE2375A9E','KS-10506',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '3955704C34FB42669912CE7A8B29995F','KS-12187',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '76FB41815F4A477E9D539B66BF2B52F4','KS-3928',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '5DF38E7FE9C6400E966FBAE60ED4DA0A','KS-3677',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '5A6265C21FA2428BA635A8F7B24487A9','KS-11857',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '0540A530D6E94DD38E83A92281268BFC','KS-3658',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', 'D83EB7063ACD462AA6EC8089D5AA77A9','KS-6624',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
INSERT INTO KRIM_ENTITY_AFLTN_T (ACTV_IND, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ENTITY_AFLTN_ID, ENTITY_ID, LAST_UPDT_DT, OBJ_ID, VER_NBR)
VALUES ('Y', 'STAFF', '0', 'N', '2C2D954F8C8245DA97112030BF43A97A','KS-10232',TO_DATE( '20140326000000', 'YYYYMMDDHH24MISS' ), sys_guid(), 0)
/
