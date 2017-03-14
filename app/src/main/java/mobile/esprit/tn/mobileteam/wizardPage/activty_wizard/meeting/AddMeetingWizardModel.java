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

package mobile.esprit.tn.mobileteam.wizardPage.activty_wizard.meeting;

import android.content.Context;

import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.AbstractWizardModel;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.BranchPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.PageList;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.meeting.CustomerAddMeetingPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.meeting.MultipleFixedChoiceMembrePage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.meeting.SingleFixedChoiceProjetPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectImagePage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectListImagePage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddvideoPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.MultipleFixedChoiceAwardPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.MultipleFixedChoiceTechnologyPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.SingleFixedChoiceTechnologyPage;

public class AddMeetingWizardModel extends AbstractWizardModel {
    public AddMeetingWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(

                new BranchPage(this, "Ajouter")
                        .addBranch("Meeting",
                                new CustomerAddMeetingPage(this, "Info Meeting")
                                        .setRequired(false),
                                new MultipleFixedChoiceMembrePage(this, "Membres")
                                        .setRequired(false),
                                new SingleFixedChoiceProjetPage(this, "Projets")
                                        .setRequired(false)
                        )


        );
    }
}
