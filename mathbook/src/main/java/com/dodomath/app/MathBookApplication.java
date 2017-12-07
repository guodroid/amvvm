/*
 * Copyright 2016 Manas Chaudhari
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dodomath.app;

import android.app.Application;
import android.content.Context;

import com.dodomath.app.tpl.ThirdPartyLoginHelper;
import com.manaschaudhari.android_mvvm.utils.BindingUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MathBookApplication extends Application {

    public static Application globalAppContext;
    public static RefWatcher getRefWatcher(Context context) {
        MathBookApplication application = (MathBookApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        this.globalAppContext = this;
        init();
    }

    private void init() {

        refWatcher = LeakCanary.install(this);

        BindingUtils.setDefaultBinder(BindingAdapters.defaultBinder);

        ThirdPartyLoginHelper.initSDK(this);

    }
}