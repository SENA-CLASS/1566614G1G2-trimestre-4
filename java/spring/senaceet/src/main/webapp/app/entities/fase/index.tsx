import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Fase from './fase';
import FaseDetail from './fase-detail';
import FaseUpdate from './fase-update';
import FaseDeleteDialog from './fase-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={FaseUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={FaseUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={FaseDetail} />
      <ErrorBoundaryRoute path={match.url} component={Fase} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={FaseDeleteDialog} />
  </>
);

export default Routes;
