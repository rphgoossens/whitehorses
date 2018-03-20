import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {JhAppSharedModule} from '../../shared';
import {BrewerySummaryComponent} from './brewery-summary.component';
import {BrewerySummaryService} from './brewery-summary.service';
import {brewerySummaryRoute} from './brewery-summary.route';

const ENTITY_STATES = [
    ...brewerySummaryRoute,
];

@NgModule({
    imports: [
        JhAppSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        BrewerySummaryComponent
    ],
    entryComponents: [
        BrewerySummaryComponent
    ],
    providers: [
        BrewerySummaryService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhAppBrewerySummaryModule {
}
