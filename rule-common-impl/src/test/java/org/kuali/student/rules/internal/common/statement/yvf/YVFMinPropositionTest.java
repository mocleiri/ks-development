package org.kuali.student.rules.internal.common.statement.yvf;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.student.rules.factfinder.dto.FactResultDTO;
import org.kuali.student.rules.factfinder.dto.FactResultTypeInfoDTO;
import org.kuali.student.rules.factfinder.dto.FactStructureDTO;
import org.kuali.student.rules.internal.common.entity.ComparisonOperator;
import org.kuali.student.rules.internal.common.utils.FactUtil;
import org.kuali.student.rules.internal.common.utils.CommonTestUtil;
import org.kuali.student.rules.rulemanagement.dto.YieldValueFunctionDTO;

public class YVFMinPropositionTest {

    public Map<String, Object> getFactMap(FactStructureDTO fs1) {
    	String factKey = FactUtil.createFactKey(fs1);

    	FactResultTypeInfoDTO columnMetaData1 = CommonTestUtil.createColumnMetaData(BigDecimal.class.getName());
        FactResultDTO factResult = CommonTestUtil.createFactResult(new String[] {"80","85","90"});
        factResult.setFactResultTypeInfo(columnMetaData1);

        Map<String, Object> factMap = new HashMap<String, Object>();
        factMap.put(factKey, factResult);
        
        return factMap;
    }

	@Test
	public void testMinProposition() throws Exception {
		YieldValueFunctionDTO yvf = new YieldValueFunctionDTO();
		FactStructureDTO fs1 = CommonTestUtil.createFactStructure("fact.id.1", "course.min.fact");
		yvf.setFactStructureList(Arrays.asList(fs1));

		Map<String, Object> factMap = getFactMap(fs1);
		
		YVFMinProposition<BigDecimal> poposition = new YVFMinProposition<BigDecimal>(
				"1", "YVFMinProposition", 
				ComparisonOperator.EQUAL_TO, new BigDecimal(80),
				yvf, factMap);

		Assert.assertTrue(poposition.apply());
		Assert.assertTrue(poposition.getResult());
		Assert.assertNotNull(poposition.getReport());
		Assert.assertNull(poposition.getReport().getFailureMessage());
		Assert.assertNotNull(poposition.getReport().getSuccessMessage());
	}
}
