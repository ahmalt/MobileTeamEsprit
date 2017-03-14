/*
 * Copyright 2013 Google Inc.
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

package mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.CustomerAddAwardFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.CustomerAddProjectFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;

/**
 * A page asking for a name and an email.
 */
public class CustomerAddAwardPage extends Page {
    public static final String NOM_DATA_KEY = "nom";
    public static final String DESCRIPTION_DATA_KEY = "description";





    public CustomerAddAwardPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return CustomerAddAwardFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("nom", mData.getString(NOM_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("description", mData.getString(DESCRIPTION_DATA_KEY), getKey(), -1));


    }

    @Override
    public boolean isCompleted() {
        return ((!TextUtils.isEmpty(mData.getString(NOM_DATA_KEY))) &&
                (!TextUtils.isEmpty(mData.getString(DESCRIPTION_DATA_KEY))));
    }
}
