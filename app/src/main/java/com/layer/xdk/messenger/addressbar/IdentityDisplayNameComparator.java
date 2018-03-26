package com.layer.xdk.messenger.addressbar;


import com.layer.sdk.messaging.Identity;
import com.layer.xdk.messenger.util.Util;

import java.util.Comparator;

public class IdentityDisplayNameComparator implements Comparator<Identity> {

    @Override
    public int compare(Identity lhs, Identity rhs) {
        return Util.getDisplayName(lhs).compareTo(Util.getDisplayName(rhs));
    }
}
