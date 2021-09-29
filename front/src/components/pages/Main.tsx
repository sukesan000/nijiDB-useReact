import { Box, Wrap, WrapItem } from '@chakra-ui/react'
import { SearchForm } from 'components/molecules/SearchForm'
import { MemberCard } from 'components/organisms/layout/member/MemberCard'
import { memo, useEffect, VFC } from 'react'
import { useAllMembers } from '../../hooks/useAllMembers'

export const Main: VFC = memo(() => {
  const { getMembers, members } = useAllMembers()

  useEffect(() => getMembers(), [getMembers])

  return (
    <>
      <Box bg="gray.50">
        <Box m="auto" w="50%">
          <SearchForm></SearchForm>
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
