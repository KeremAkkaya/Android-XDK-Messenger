package com.layer.xdk.messenger;


import com.layer.xdk.ui.DefaultXdkUiComponent;
import com.layer.xdk.ui.ServiceLocator;

/**
 * Singleton that wraps a {@link ServiceLocator} instance.
 */
public enum LayerServiceLocatorManager {
    INSTANCE;

    private ServiceLocator mServiceLocator;

    public ServiceLocator getInstance() {
        if (mServiceLocator == null) {
            mServiceLocator = new ServiceLocator();
        }
        return mServiceLocator;
    }

    /**
     * Convenience method to get the {@link DefaultXdkUiComponent} from the service locator. This
     * component uses the dependencies provided in the wrapped service locator for object
     * instantiation.
     *
     * @return a component to create XDK objects
     */
    public DefaultXdkUiComponent getComponent() {
        return getInstance().getXdkUiComponent();
    }
}
