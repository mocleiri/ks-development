package org.kuali.student.rules.brms.core.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class LoadBeanListener implements ApplicationListener {
    private LoadDataBean ldb;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            ldb.loadData();
        }
    }

    /**
     * @return the ldb
     */
    public LoadDataBean getLdb() {
        return ldb;
    }

    /**
     * @param ldb
     *            the ldb to set
     */
    public void setLdb(LoadDataBean ldb) {
        this.ldb = ldb;
    }
}
