package com.layer.xdk.messenger.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.layer.sdk.messaging.Identity;
import com.layer.xdk.ui.XdkUiDependencyManager;
import com.layer.xdk.ui.conversation.ConversationItemFormatter;
import com.layer.xdk.ui.identity.IdentityFormatter;
import com.layer.xdk.ui.message.image.cache.ImageCacheWrapper;
import com.layer.xdk.ui.message.image.cache.PicassoImageCacheWrapper;

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
        return XdkUiDependencyManager.INSTANCE.getServiceLocator().getImageCacheWrapper();
    }

    public static IdentityFormatter getIdentityFormatter() {
        return XdkUiDependencyManager.INSTANCE.getServiceLocator().getIdentityFormatter();
    }

    public static ConversationItemFormatter getConversationItemFormatter() {
        return XdkUiDependencyManager.INSTANCE.getServiceLocator().getConversationItemFormatter();
    }

    public static void copyToClipboard(Context context, int stringResId, String content) {
        copyToClipboard(context, context.getString(stringResId), content);
    }

    public static void copyToClipboard(Context context, String description, String content) {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = new ClipData(description, new String[]{"text/plain"}, new ClipData.Item(content));
        manager.setPrimaryClip(clipData);
    }

    @NonNull
    public static String getDisplayName(Identity identity) {
        if (TextUtils.isEmpty(identity.getDisplayName())) {
            String first = identity.getFirstName();
            String last = identity.getLastName();
            if (!TextUtils.isEmpty(first)) {
                if (!TextUtils.isEmpty(last)) {
                    return String.format("%s %s", first, last);
                }
                return first;
            } else if (!TextUtils.isEmpty(last)) {
                return last;
            } else {
                return identity.getUserId();
            }
        }
        return identity.getDisplayName();
    }
}
