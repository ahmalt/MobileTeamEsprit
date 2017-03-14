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

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

import mobile.esprit.tn.mobileteam.Models.Award;
import mobile.esprit.tn.mobileteam.Models.Technology;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.SingleChoiceMembreFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.ui.SingleChoiceFragment;

/**
 * A page offering the user a number of mutually exclusive choices.
 */
public class SingleFixedChoiceAwardPage extends Page {
    String TAG = SingleFixedChoiceAwardPage.class.getSimpleName();
    protected ArrayList<Award> mChoices = new ArrayList<>();
    private ArrayList<Award> items = new ArrayList<>();
    Context context;

    public SingleFixedChoiceAwardPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return SingleChoiceFragment.create(getKey());
    }

    public Award getOptionAt(int position) {
        return mChoices.get(position);
    }

    public int getOptionCount() {
        return mChoices.size();
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem(getTitle(), mData.getString(SIMPLE_DATA_KEY), getKey()));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
    }

    public SingleFixedChoiceAwardPage setChoices(Award... choices) {
        mChoices.addAll(Arrays.asList(choices));
        return this;
    }

    public SingleFixedChoiceAwardPage setValue(String value) {
        mData.putString(SIMPLE_DATA_KEY, value);
        return this;
    }

}