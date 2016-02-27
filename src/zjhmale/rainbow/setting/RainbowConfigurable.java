package zjhmale.rainbow.setting;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by zjh on 2016/2/16.
 */
public class RainbowConfigurable implements Configurable {
    private RainbowSettingsForm settingsForm;

    public RainbowConfigurable() {
        super();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (settingsForm == null) {
            settingsForm = new RainbowSettingsForm();
        }
        return settingsForm.getComponent();
    }

    @Override
    public boolean isModified() {
        return settingsForm.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        RainbowSettings settings = RainbowSettings.getInstance();
        settings.isRainbowIdentifier = settingsForm.isRainbowIdentifier();
        settings.isRainbowDelimiter = settingsForm.isRainbowDelimiter();
    }

    @Override
    public void reset() {
        if (settingsForm != null) {
            settingsForm.reset();
        }
    }

    @Override
    public void disposeUIResources() {
        settingsForm = null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Rainbow";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }
}
