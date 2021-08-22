import { memo, VFC } from 'react'
import { Route, Switch } from 'react-router-dom'
import { HeaderLayout } from 'templates/HeaderLayout'
import { homeRoutes } from './HomeRoutes'

export const Router: VFC = memo(() => {
  return (
    <Switch>
      <Route
        path="/"
        render={({ match: { url } }) => (
          <Switch>
            {homeRoutes.map((route) => (
              <Route
                key={route.path}
                exact={route.exact}
                path={`${url}${route.path}`}
              >
                <HeaderLayout>{route.children}</HeaderLayout>
              </Route>
            ))}
          </Switch>
        )}
      ></Route>
    </Switch>
  )
})
