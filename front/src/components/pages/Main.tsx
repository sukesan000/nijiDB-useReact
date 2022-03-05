import { Box, Wrap, WrapItem, Flex, Input, Button } from '@chakra-ui/react'
import axios from 'axios'
import { MemberCard } from 'components/organisms/layout/member/MemberCard'
import { useMessage } from 'hooks/useMessage'
import { memo, useEffect, useState, VFC } from 'react'
import { Member } from 'types/api/member'

export const Main: VFC = memo(() => {
  const [members, setMembers]: [Array<Member>, any] = useState<Array<Member>>(
    [],
  )
  const [word, setWord] = useState<string>('')
  const { showMessage } = useMessage()
  const onChangeWord = (e: any) => setWord(e.target.value)
  const OnClickFindMembers = () => {
    const api = 'http://localhost:8080/nijidb/search/' + word
    axios
      .post<Array<Member>>(api)
      .then((res) => {
        setMembers(res.data)
      })
      .catch(() => {
        showMessage({ title: 'ユーザ取得に失敗しました', status: 'error' })
      })
  }

  useEffect(() => {
    if (word === '') {
      axios
        .get<Array<Member>>('http://localhost:8080/nijidb')
        .then((res) => {
          setMembers(res.data)
        })
        .catch(() => {
          console.log('メンバー取得に失敗しました')
        })
    }
  })

  return (
    <>
      <Box bg="gray.50">
        <Box m="auto" w="50%">
          <Box p="15px">
            <Flex justify="center">
              <Input
                onChange={onChangeWord}
                onKeyDown={(e) => {
                  if (e.key === 'Enter') {
                    e.preventDefault()
                    OnClickFindMembers()
                  }
                }}
                borderRadius="full"
                shadow="lg"
                placeholder="ライバー名"
                value={word}
              />
              <Button
                onClick={OnClickFindMembers}
                ml="15px"
                colorScheme="teal"
                borderRadius="15px"
                shadow="lg"
                type="submit"
              >
                検索
              </Button>
            </Flex>
          </Box>
        </Box>
        <Wrap p={10} justify="center">
          {members.map((member) => (
            <WrapItem key={member.id}>
              <MemberCard
                imageUrl={member.thumbnail}
                name={member.name}
                subscriber={member.subscriber}
              />
            </WrapItem>
          ))}
        </Wrap>
      </Box>
    </>
  )
})
