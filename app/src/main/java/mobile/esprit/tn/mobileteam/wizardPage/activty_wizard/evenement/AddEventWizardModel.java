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

package mobile.esprit.tn.mobileteam.wizardPage.activty_wizard.evenement;

import android.content.Context;

import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.AbstractWizardModel;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.BranchPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.PageList;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.news.CustomerAddNewsPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectListImagePage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddvideoPage;

public class AddEventWizardModel extends AbstractWizardModel {
    public AddEventWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(

                new BranchPage(this, "Ajouter")
                        .addBranch("Evénement",
                                new CustomerAddNewsPage(this, "Info événement")
                                        .setRequired(false),
                                new CustomerAddvideoPage(this, "Video")
                                        .setRequired(false),
                                new CustomerAddProjectListImagePage(this, "Images")
                                        .setRequired(false)

                        )


        );
    }
}
