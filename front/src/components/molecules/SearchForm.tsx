import { memo } from 'react'
import { Box, Button, Flex, Input } from '@chakra-ui/react'
import { useState } from 'react'

type Props = {
  setValue: React.Dispatch<React.SetStateAction<string[]>>
}

export const SearchForm = memo((props: Props) => {
  let { setValue } = props
  const [word, setWord] = useState<any>('')
  //const { searchMember, members } = useFindMembers()
  const OnClickFindMembers = () => {
    setValue(word)
  }
  const onChangeWord = (e: any) => setWord(e.target.value)

  return (
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
  )
})
