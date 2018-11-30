import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Cliente from './cliente';
import ClienteDetail from './cliente-detail';
import ClienteUpdate from './cliente-update';
import ClienteDeleteDialog from './cliente-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={ClienteUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={ClienteUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={ClienteDetail} />
      <ErrorBoundaryRoute path={match.url} component={Cliente} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={ClienteDeleteDialog} />
  </>
);

export default Routes;
