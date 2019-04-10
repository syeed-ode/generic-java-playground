package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.dependencies;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


public class DependencyServiceTest {

    DependencyService service = new DependencyService();
    private String [] projects = {"a", "b", "c", "d", "e", "f"};
    private String [][] dependencies = {  {"a", "d"}
                                        , {"f", "b"}
                                        , {"b", "d"}
                                        , {"f", "a"}
                                        , {"d", "c"}};

    @Test
    public void findBuildOrder_Success() {
        System.out.println(StringUtils.join(service.findBuildOrder(projects, dependencies), '\n'));
    }
}
