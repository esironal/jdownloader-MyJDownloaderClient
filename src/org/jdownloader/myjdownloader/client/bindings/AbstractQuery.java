package org.jdownloader.myjdownloader.client.bindings;

import org.jdownloader.myjdownloader.client.json.AbstractJsonData;

public abstract class AbstractQuery extends AbstractJsonData {

    private boolean bytesTotal = false;
    private boolean comment    = false;
    private boolean status     = false;
    private boolean priority   = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean enabled = false;

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    private int    maxResults = -1;
    private int    startAt    = 0;
    private long[] packageUUIDs;

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public int getStartAt() {
        return startAt;
    }

    public boolean isBytesTotal() {
        return bytesTotal;
    }

    public boolean isComment() {
        return comment;
    }

    public void setStartAt(final int startAt) {
        this.startAt = startAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setBytesTotal(final boolean size) {
        bytesTotal = size;
    }

    public void setComment(final boolean comment) {
        this.comment = comment;
    }

    public void setMaxResults(final int maxResults) {
        this.maxResults = maxResults;
    }

    public long[] getPackageUUIDs() {
        return packageUUIDs;
    }

    public void setPackageUUIDs(final long[] packageUUIDs) {
        this.packageUUIDs = packageUUIDs;
    }

}
