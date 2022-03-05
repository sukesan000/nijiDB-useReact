import { Box, Wrap, WrapItem, Flex, Input, Button } from '@chakra-ui/react'
import axios from 'axios'
import { MemberCard } from 'components/organisms/layout/member/MemberCard'
import { useFindMembers } from 'hooks/useFindMembers'
import { memo, useEffect, useState, VFC } from 'react'
import { Member } from 'types/api/member'

export const Main: VFC = memo(() => {
  const [members, setMembers]: [Array<Member>, any] = useState<Array<Member>>(
    [],
  )
  const [word, setWord] = useState<string>('')
  const { searchMember, resMembers } = useFindMembers()
  const onChangeWord = (e: any) => setWord(e.target.value)
  const OnClickFindMembers = () => {
    searchMember(word)
    setMembers(resMembers)
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
