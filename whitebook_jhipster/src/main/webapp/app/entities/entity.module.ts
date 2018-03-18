import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { JhAppBeerModule } from './beer/beer.module';
import { JhAppBreweryModule } from './brewery/brewery.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        JhAppBeerModule,
        JhAppBreweryModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhAppEntityModule {}
