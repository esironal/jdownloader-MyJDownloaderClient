package org.jdownloader.myjdownloader.client.bindings.interfaces;

import org.jdownloader.myjdownloader.client.bindings.ClientApiNameSpace;
import org.jdownloader.myjdownloader.client.exceptions.device.ApiFileNotFoundException;
import org.jdownloader.myjdownloader.client.exceptions.device.InternalServerErrorException;
import org.jdownloader.myjdownloader.client.json.IconDescriptor;

@ClientApiNameSpace("contentV2")
public interface ContentInterface extends Linkable {

    public byte[] getFavIcon(String hostername) throws ApiFileNotFoundException, InternalServerErrorException;

    public byte[] getFileIcon(String filename) throws InternalServerErrorException;

    public byte[] getIcon(String key, int size) throws InternalServerErrorException;

    public IconDescriptor getIconDescription(String key) throws InternalServerErrorException;

}
