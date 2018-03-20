import {UserRouteAccessService} from '../../shared';
import {Routes} from '@angular/router/src/config';
import {BrewerySummaryComponent} from './brewery-summary.component';

export const brewerySummaryRoute: Routes = [
    {
        path: 'brewery-summary',
        component: BrewerySummaryComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'jhipsterApp.brewery-summary.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];
