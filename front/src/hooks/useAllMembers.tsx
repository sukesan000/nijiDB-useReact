import axios from 'axios'
import { useCallback, useState } from 'react'
import { Member } from '../types/api/member'
import { useMessage } from './useMessage'

export const useAllMembers = () => {
  const { showMessage } = useMessage()
  const [members, setMembers] = useState<Array<Member>>([])

  const getMembers = useCallback(() => {
    axios
      .get<Array<Member>>('http://localhost:8080/nijidb')
      .then((res) => {
        setMembers(res.data)
      })
      .catch(() => {
        showMessage({ title: 'ユーザ取得に失敗しました', status: 'error' })
      })
  }, [showMessage])
  return { getMembers, members }
}
