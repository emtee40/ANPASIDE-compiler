package com.github.helltar.anpaside.ide;

import static com.github.helltar.anpaside.Consts.DIR_LIBS;
import static com.github.helltar.anpaside.Consts.WORK_DIR_PATH;

import android.content.Context;
import android.content.SharedPreferences;

public class IdeConfig {

    private final String PREF_NAME_INSTALL = "install";
    private final String PREF_NAME_UPDATE = "update_assets";
    private final String PREF_NAME_GLOBAL_DIR_PATH = "global_libs_dir";

    private final Context context;

    public IdeConfig(Context context) {
        this.context = context;
    }

    private SharedPreferences getSpMain() {
        return context.getSharedPreferences("ide_config", Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getMainEditor() {
        return getSpMain().edit();
    }

    private boolean getInstState() {
        return getSpMain().getBoolean(PREF_NAME_INSTALL, false);
    }

    public void setInstState(boolean val) {
        getMainEditor().putBoolean(PREF_NAME_INSTALL, val).apply();
    }

    private int getUpdateAssetsState() {
        return getSpMain().getInt(PREF_NAME_UPDATE, 0);
    }

    public void setUpdateAssetsState(int val) {
        getMainEditor().putInt(PREF_NAME_UPDATE, val).apply();
    }

    public String getGlobalDirPath() {
        return getSpMain().getString(PREF_NAME_GLOBAL_DIR_PATH, WORK_DIR_PATH + DIR_LIBS);
    }

    public void setGlobalDirPath(String path) {
        getMainEditor().putString(PREF_NAME_GLOBAL_DIR_PATH, path).apply();
    }

    public boolean isAssetsInstall() {
        return getInstState();
    }

    public boolean isAssetsUpdate(int i) {
        return getUpdateAssetsState() == i;
    }
}
