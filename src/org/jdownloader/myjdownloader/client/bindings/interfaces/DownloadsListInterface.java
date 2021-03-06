package org.jdownloader.myjdownloader.client.bindings.interfaces;

import java.util.HashMap;
import java.util.List;

import org.jdownloader.myjdownloader.client.bindings.CleanupActionOptions;
import org.jdownloader.myjdownloader.client.bindings.ClientApiNameSpace;
import org.jdownloader.myjdownloader.client.bindings.PriorityStorable;
import org.jdownloader.myjdownloader.client.bindings.UrlDisplayTypeStorable;
import org.jdownloader.myjdownloader.client.bindings.downloadlist.DownloadLinkQuery;
import org.jdownloader.myjdownloader.client.bindings.downloadlist.DownloadLinkStorable;
import org.jdownloader.myjdownloader.client.bindings.downloadlist.DownloadPackageQuery;
import org.jdownloader.myjdownloader.client.bindings.downloadlist.DownloadPackageStorable;

@ClientApiNameSpace("downloadsV2")
public interface DownloadsListInterface extends Linkable {

    void setEnabled(boolean enabled, long[] linkIds, long[] packageIds);

    void setStopMark(long linkId, long packageId);

    void removeStopMark();

    long getStopMark();

    int packageCount();

    List<DownloadPackageStorable> queryPackages(DownloadPackageQuery queryParams);

    void removeLinks(final long[] linkIds, final long[] packageIds);

    void renamePackage(Long packageId, String newName);

    void renameLink(Long linkId, String newName);

    void resetLinks(long[] linkIds, long[] packageIds);

    /**
     * Returns the new Counter if the counter does not equal oldCounterValue If the value changed, we should update the structure. Use this
     * method to check whether a structure update is required or not
     * 
     * @param oldCounterValue
     * @return
     */
    long getStructureChangeCounter(long oldCounterValue);

    void movePackages(long[] packageIds, long afterDestPackageId);

    void moveLinks(long[] linkIds, long afterLinkID, long destPackageID);

    /**
     * Set the priority for the given link or package ids
     * 
     * @param priority
     * @param linkIds
     * @param packageIds
     */
    void setPriority(PriorityStorable priority, long[] linkIds, long[] packageIds);

    /**
     * Query Packages links in downloads
     * 
     * Example: http://localhost:3128/downloads/queryLinks?{"packageUUIDs":[
     * 1358496436106,1358496436107],"enabled":true,"size":true,"host":true ,"startAt":0,"maxResults":10}
     * 
     * Default fields returned: name, uuid, packageUUID
     * 
     * @param queryParams
     *            Hashmap with the following allowed values:
     * 
     *            Optional selectors: packageUUIDs, long[], links contained in the packages with given uuids are returned, if empty all
     *            links are returned startAt, Integer, index of first element to be returned maxResults, Integer, total number of elements
     *            to be returned
     * 
     *            Optional fields (Boolean): host size done enabled
     * 
     * @return
     */
    List<DownloadLinkStorable> queryLinks(DownloadLinkQuery queryParams);

    void resumeLinks(long[] linkIds, long[] pkgIds);

    void setDownloadDirectory(String directory, long[] pkgIds);

    DownloadLinkStorable getStopMarkedLink();

    void startOnlineStatusCheck(long[] linkIds, long[] packageIds);

    HashMap<String, Long[]> getDownloadUrls(long[] linkIds, long[] packageIds, UrlDisplayTypeStorable[] urlDisplayTypes);

    void movetoNewPackage(long[] linkIds, long[] pkgIds, String newPkgName, String downloadPath);

    void splitPackageByHoster(long[] linkIds, long[] pkgIds);

    void cleanup(final long[] linkIds, final long[] packageIds, final CleanupActionOptions.Action action, final CleanupActionOptions.Mode mode, final CleanupActionOptions.SelectionType selectionType);

    boolean setDownloadPassword(long[] linkIds, long[] packageIds, String pass);

}
