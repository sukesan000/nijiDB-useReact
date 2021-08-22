import { Main } from 'components/pages/Main'

export const homeRoutes = [
  {
    path: '',
    exact: true,
    children: <Main />,
  },
]
