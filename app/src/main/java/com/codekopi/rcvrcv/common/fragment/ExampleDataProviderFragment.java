/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.codekopi.rcvrcv.common.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.codekopi.rcvrcv.common.data.AbstractDataProvider;
import com.codekopi.rcvrcv.common.data.ExampleDataProvider;


public class ExampleDataProviderFragment extends Fragment {
    private AbstractDataProvider mDataProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleDataProvider();
    }

    public AbstractDataProvider getDataProvider() {
        return mDataProvider;
    }
}
