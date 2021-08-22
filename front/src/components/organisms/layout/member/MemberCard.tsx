import { Box, Image, Stack, Text } from '@chakra-ui/react'
import { memo, VFC } from 'react'

type Props = {
  name: string
  imageUrl: string
  subscriber: string
  videoCount: string
}
export const MemberCard: VFC<Props> = memo((props) => {
  const { name, imageUrl, subscriber, videoCount } = props
  return (
    <Box
      p={4}
      w="200px"
      h="300px"
      bg="gray.600"
      borderRadius="10px"
      shadow="md"
    >
      <Stack textAlign="center">
        <Image boxSize="160px" borderRadius="full" m="auto" src={imageUrl} />
        <Text color="gray.100" fontWeight="bold">
          {name}
        </Text>
        <Text color="gray.100">{subscriber}</Text>
        <Text color="gray.100">{videoCount}</Text>
      </Stack>
    </Box>
  )
})
