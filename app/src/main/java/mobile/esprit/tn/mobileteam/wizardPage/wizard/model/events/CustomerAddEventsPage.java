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

package mobile.esprit.tn.mobileteam.wizardPage.wizard.model.events;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.events.CustomerAddEventsFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.news.CustomerAddNewsFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;

/**
 * A page asking for a name and an email.
 */
public class CustomerAddEventsPage extends Page {
    public static final String NOM_DATA_KEY = "nom";
    public static final String DESCRIPTION_DATA_KEY = "description";
    public static final String DATE_START_DATA_KEY = "date_start";
    public static final String HEURE_START_DATA_KEY = "heure_start";
    public static final String DATE_END_DATA_KEY = "date_end";
    public static final String HEURE_END_DATA_KEY = "heure_end";




    public CustomerAddEventsPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return CustomerAddEventsFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("nom", mData.getString(NOM_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("description", mData.getString(DESCRIPTION_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("date_start", mData.getString(DATE_START_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("heure_start", mData.getString(HEURE_START_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("date_end", mData.getString(DATE_END_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("heure_end", mData.getString(HEURE_END_DATA_KEY), getKey(), -1));


    }

    @Override
    public boolean isCompleted() {
        return ((!TextUtils.isEmpty(mData.getString(NOM_DATA_KEY))) &&
                (!TextUtils.isEmpty(mData.getString(DATE_START_DATA_KEY)))&&
                (!TextUtils.isEmpty(mData.getString(HEURE_START_DATA_KEY)))&&
                (!TextUtils.isEmpty(mData.getString(DATE_END_DATA_KEY)))&&
                (!TextUtils.isEmpty(mData.getString(HEURE_END_DATA_KEY)))&&

                (!TextUtils.isEmpty(mData.getString(DESCRIPTION_DATA_KEY))));
    }
}
