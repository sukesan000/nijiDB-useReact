import { Main } from 'components/pages/Main'

export const homeRoutes = [
  {
    path: 'nijiDB',
    exact: true,
    children: <Main />,
  },
]
