package org.supamassirichotiyakul.catermate.order;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class QueryObj {
    private String queryName = "";

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date queryDeliveryDate;

    private String queryLocation = "";

    public QueryObj() {
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Date getQueryDeliveryDate() {
        return queryDeliveryDate;
    }

    public void setQueryDeliveryDate(Date queryDeliveryDate) {
        this.queryDeliveryDate = queryDeliveryDate;
    }

    public String getQueryLocation() {
        return queryLocation;
    }

    public void setQueryLocation(String queryLocation) {
        this.queryLocation = queryLocation;
    }
}
