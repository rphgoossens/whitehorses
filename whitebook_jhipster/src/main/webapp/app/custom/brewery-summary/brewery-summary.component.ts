import {Component, OnDestroy, OnInit} from '@angular/core';
import {BrewerySummary} from './brewery-summary.model';
import {Principal} from '../../shared';
import {JhiAlertService, JhiEventManager} from 'ng-jhipster';
import {BrewerySummaryService} from './brewery-summary.service';
import {Subscription} from 'rxjs/Subscription';
import {HttpErrorResponse, HttpResponse} from '@angular/common/http';

@Component({
    selector: 'jhi-brewery-summary',
    templateUrl: './brewery-summary.component.html',
    styles: []
})
export class BrewerySummaryComponent implements OnInit, OnDestroy {
    brewerySummaries: BrewerySummary[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(private brewerySummaryService: BrewerySummaryService,
                private jhiAlertService: JhiAlertService,
                private eventManager: JhiEventManager,
                private principal: Principal) {
    }

    loadAll() {
        this.brewerySummaryService.query().subscribe(
            (res: HttpResponse<BrewerySummary[]>) => {
                this.brewerySummaries = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInBrewerySummaries();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInBrewerySummaries() {
        this.eventSubscriber = this.eventManager.subscribe('brewerySummaryListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }

}
