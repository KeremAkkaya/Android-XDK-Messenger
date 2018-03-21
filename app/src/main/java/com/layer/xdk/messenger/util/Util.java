package com.layer.xdk.messenger.util;

import com.layer.xdk.messenger.LayerServiceLocatorManager;
import com.layer.xdk.ui.conversation.ConversationItemFormatter;
import com.layer.xdk.ui.identity.IdentityFormatter;
import com.layer.xdk.ui.util.imagecache.ImageCacheWrapper;
import com.layer.xdk.ui.util.imagecache.PicassoImageCacheWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class Util {

    public static String streamToString(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }
    /**
     * Provides an instance of {@link ImageCacheWrapper} for caching image
     * This sample app implementation uses Picasso, see {@link PicassoImageCacheWrapper}
     * Replace the implementation with whatever Image Caching library you wish to use.
     */
    public static ImageCacheWrapper getImageCacheWrapper() {
        return LayerServiceLocatorManager.INSTANCE.getComponent().imageCacheWrapper();
    }

    public static IdentityFormatter getIdentityFormatter() {
        return LayerServiceLocatorManager.INSTANCE.getComponent().identityFormatter();
    }

    public static ConversationItemFormatter getConversationItemFormatter() {
        return LayerServiceLocatorManager.INSTANCE.getComponent().conversationItemFormatter();
    }

}
