import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {SERVER_API_URL} from '../../app.constants';
import {createRequestOption} from '../../shared';
import {BrewerySummary} from './brewery-summary.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class BrewerySummaryService {

    private resourceUrl = SERVER_API_URL + 'api/brewery-summary';

    constructor(private http: HttpClient) {
    }

    query(req?: any): Observable<HttpResponse<BrewerySummary[]>> {
        const options = createRequestOption(req);
        return this.http.get<BrewerySummary[]>(this.resourceUrl, {params: options, observe: 'response'})
            .map((res: HttpResponse<BrewerySummary[]>) => this.convertArrayResponse(res));
    }

    private convertArrayResponse(res: HttpResponse<BrewerySummary[]>): HttpResponse<BrewerySummary[]> {
        const jsonResponse: BrewerySummary[] = res.body;
        const body: BrewerySummary[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to BrewerySummary.
     */
    private convertItemFromServer(brewerySummary: BrewerySummary): BrewerySummary {
        const copy: BrewerySummary = Object.assign({}, brewerySummary);
        return copy;
    }

}
