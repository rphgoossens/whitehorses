import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {JhAppBrewerySummaryModule} from './brewery-summary/brewery-summary.module';

@NgModule({
    imports: [
        JhAppBrewerySummaryModule
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhAppCustomModule {
}
