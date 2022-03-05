import axios from 'axios'
import { useCallback, useState } from 'react'
import { Member } from '../types/api/member'
import { useMessage } from './useMessage'

export const useFindMembers = () => {
  const { showMessage } = useMessage()
  const [resMembers, setResMembers] = useState<Array<Member>>([])
  const searchMember = useCallback(
    (word: string) => {
      const api = 'http://localhost:8080/nijidb/search/' + word

      axios
        .post<Array<Member>>(api)
        .then((res) => {
          setResMembers(res.data)
        })
        .catch(() => {
          showMessage({ title: 'ユーザ取得に失敗しました', status: 'error' })
        })
    },
    [showMessage],
  )
  return { searchMember, resMembers }
}
